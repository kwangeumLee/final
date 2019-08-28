package lsis.pal.assign.finalApp;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class JdbcPalMemberRepository implements PalMemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPalMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public PalMember create(PalMember palMember) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO pal_members (name, gender, description) " +
                            "VALUES (?, ?, ?)",
                    RETURN_GENERATED_KEYS
            );



            statement.setString(1, palMember.getName());
            statement.setLong(2, palMember.getGender());
            statement.setString(3, palMember.getDescription());

            return statement;
        }, generatedKeyHolder);

        return find(generatedKeyHolder.getKey().longValue());
    }

    @Override
    public PalMember find(Long id) {
        return jdbcTemplate.query(
                "SELECT id, name, gender, description FROM pal_members WHERE id = ?",
                new Object[]{id},
                extractor);
    }

    @Override
    public List<PalMember> list() {
        return jdbcTemplate.query("SELECT id, name, gender, description FROM pal_members", mapper);
    }

    @Override
    public PalMember update(Long id, PalMember palMember) {
        jdbcTemplate.update("UPDATE pal_members " +
                        "SET name = ?, gender = ?, description = ?" +
                        "WHERE id = ?",
                palMember.getName(),
                palMember.getGender(),
                palMember.getDescription(),
                id);

        return find(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM pal_members WHERE id = ?", id);
    }

    private final RowMapper<PalMember> mapper = (rs, rowNum) -> new PalMember(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getLong("gender"),
            rs.getString("description")
    );

    private final ResultSetExtractor<PalMember> extractor =
            (rs) -> rs.next() ? mapper.mapRow(rs, 1) : null;
}

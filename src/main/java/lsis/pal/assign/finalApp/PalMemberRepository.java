package lsis.pal.assign.finalApp;

import java.util.List;

public interface PalMemberRepository {
    PalMember create(PalMember palMember);
    PalMember find(Long id);
    List<PalMember> list();
    PalMember update(Long id, PalMember palMember);
    void delete(Long id);

}

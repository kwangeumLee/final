package lsis.pal.assign.finalApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryPalMemberRepository implements PalMemberRepository {

    private HashMap<Long, PalMember> palMembers = new HashMap<>();

    private long currentId = 1L;

    @Override
    public PalMember create(PalMember palMember) {
        Long id = currentId++;

        PalMember newPalMember = new PalMember(
                id,
                palMember.getName(),
                palMember.getGender(),
                palMember.getDescription()
        );

        palMembers.put(id, newPalMember);
        return newPalMember;
    }

    @Override
    public PalMember find(Long id) {
        return palMembers.get(id);
    }

    @Override
    public List<PalMember> list() {
        return new ArrayList<>(palMembers.values());
    }

    @Override
    public PalMember update(Long id, PalMember palMember) {
        if (find(id) == null) return null;

        PalMember updatedPalMember = new PalMember(
                id,
                palMember.getName(),
                palMember.getGender(),
                palMember.getDescription()
        );

        palMembers.replace(id, updatedPalMember);
        return updatedPalMember;
    }

    @Override
    public void delete(Long id) {
        palMembers.remove(id);
    }
}

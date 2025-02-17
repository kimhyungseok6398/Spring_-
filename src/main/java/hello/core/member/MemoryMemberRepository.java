package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    // 동시성 이슈 문제(간단한 예시로 작성)
    // 저장소
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
        //Member -> MemberRepository -> MemoryMemberRepository ->
        // MemberService
    }
}



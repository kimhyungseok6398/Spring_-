package hello.core.member;

public interface MemberService {
    void join(Member member);
    //  조인
    Member findMember(Long memberId);
    // 조회

    }


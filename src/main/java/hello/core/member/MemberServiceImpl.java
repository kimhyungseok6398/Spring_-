package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }   // 생성자를 통해서 구현체가 무엇이 들어갈지 생성자를 통해 선택
        // 이것이 생성자 주입 방식
    // 단축키 팁 = ctrn + shift + enter 하면
    // 자동으로 세미클론 까지 작성을 해준다.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        // 다형성에 의해 MemoryMemberRepository 
        // save 호출
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    // 단축키 설명 new 하고 엔터를 치면
    // 세미클론이 안들어가기 때문에



}

package com.wani.abeepagetutorial.application;

import com.wani.abeepagetutorial.request.MemberEnrollRequest;
import com.wani.abeepagetutorial.response.MemberPageResponse;
import com.wani.abeepagetutorial.response.MemberResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    public MemberPageResponse findMembers(int page, int size) {
        return null;
    }

    public MemberResponse findMember(Long id) {
        return null;
    }

    public MemberResponse enrollMember(MemberEnrollRequest request) {
        return null;
    }

    public MemberResponse enrollAdmin(MemberEnrollRequest request) {
        return null;
    }
}

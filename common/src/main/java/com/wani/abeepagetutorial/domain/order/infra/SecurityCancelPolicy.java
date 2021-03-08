package com.wani.abeepagetutorial.domain.order.infra;

import com.wani.abeepagetutorial.domain.order.entity.Canceller;
import com.wani.abeepagetutorial.domain.order.entity.Orders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SecurityCancelPolicy implements CancelPolicy {

    @Override
    public boolean hasCancellationPermission(Orders orders, Canceller canceller) {
        return isCancellerOrderer(orders, canceller) || isCurrentUserAdminRole();
    }

    private boolean isCancellerOrderer(Orders orders, Canceller canceller) {
        return true;
    }

    private boolean isCurrentUserAdminRole() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) return false;
        Authentication authentication = context.getAuthentication();
        if (authentication == null) return false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities == null) return false;
        return authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
    }
}

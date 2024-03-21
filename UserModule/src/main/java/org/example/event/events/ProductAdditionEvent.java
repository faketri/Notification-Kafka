package org.example.event.events;

import org.example.entity.Users;
import org.springframework.context.ApplicationEvent;

import java.util.List;
import java.util.Set;

public class ProductAdditionEvent extends ApplicationEvent {

    private Set<Users> usersSubscribe;

    public ProductAdditionEvent(Object source, Set<Users> usersSubscribe) {
        super(source);
        this.usersSubscribe = usersSubscribe;
    }

    public Set<Users> getUsersSubscribe() {
        return usersSubscribe;
    }

    public void setUsersSubscribe(Set<Users> usersSubscribe) {
        this.usersSubscribe = usersSubscribe;
    }
}

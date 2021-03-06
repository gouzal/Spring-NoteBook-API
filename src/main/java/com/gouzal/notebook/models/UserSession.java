package com.gouzal.notebook.models;

import lombok.Getter;
import lombok.Setter;
import org.graalvm.polyglot.Context;

import java.io.Serializable;
import java.util.Objects;

/**
 * The class that will hold and match the GraalVM context with its user sessionId
 */
@Setter
@Getter
public class UserSession implements Serializable {
    private String sessionId;
    private Context context;

    public UserSession(String sessionId) {
        this.sessionId = sessionId;
        //todo: context could be injected for better testing capabilities and loose coupling
        this.context = Context.create();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSession)) return false;
        UserSession that = (UserSession) o;
        return Objects.equals(getSessionId(), that.getSessionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSessionId());
    }

    /**
     * Close the User context
     */
    public void closeContext(){
        this.context.close();
    }
}

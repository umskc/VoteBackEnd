package pl.plenczewski.voicesystem.model;

import java.util.List;

public class VoteRequest {

    private List<Long> idsOfLocalprojects;
    private List<Long> idsOfGlobalprojects;
    private String token;

    public VoteRequest() {
    }

    public VoteRequest(List<Long> idsOfLocalprojects, List<Long> idsOfGlobalprojects, String token) {
        this.idsOfLocalprojects = idsOfLocalprojects;
        this.idsOfGlobalprojects = idsOfGlobalprojects;
        this.token = token;
    }

    public List<Long> getIdsOfLocalprojects() {
        return idsOfLocalprojects;
    }

    public List<Long> getIdsOfGlobalprojects() {
        return idsOfGlobalprojects;
    }

    public String getToken() {
        return token;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        public Builder() {

        }

        private List<Long> idsOfLocalprojects;
        private List<Long> idsOfGlobalprojects;
        private String token;

        public Builder setIdsOfLocalProjects(List<Long> idsOfLocalProjects) {
            this.idsOfLocalprojects = idsOfLocalProjects;
            return this;
        }

        public Builder setIdsOfGlobalProjects(List<Long> idsOfGlobalProjects) {
            this.idsOfGlobalprojects = idsOfGlobalProjects;
            return this;
        }

        public Builder settoken(String token) {
            this.token = token;
            return this;
        }

        public VoteRequest build() {
            if (idsOfGlobalprojects.size() < 1) {
                throw new IllegalStateException("Global projects ID's cannot be empty.");
            }
            if (idsOfLocalprojects.size() < 1) {
                throw new IllegalStateException("Local projects ID's cannot be empty.");
            }
            if(token == null) {
                throw new IllegalStateException("Token cannot be null.");
            }
            return new VoteRequest(idsOfLocalprojects, idsOfGlobalprojects, token);
        }
    }
}

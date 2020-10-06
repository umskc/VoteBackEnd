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

    public void setIdsOfLocalprojects(List<Long> idsOfLocalprojects) {
        this.idsOfLocalprojects = idsOfLocalprojects;
    }

    public List<Long> getIdsOfGlobalprojects() {
        return idsOfGlobalprojects;
    }

    public void setIdsOfGlobalprojects(List<Long> idsOfGlobalprojects) {
        this.idsOfGlobalprojects = idsOfGlobalprojects;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

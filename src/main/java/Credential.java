public class Credential {
    private String subDomain;
    private String email;
    private String password;

    public Credential() {
        this.subDomain = "";
        this.email = "";
        this.password = "";
    }

    public Credential(String subDomain, String email, String password) {
        this.subDomain = subDomain;
        this.email = email;
        this.password = password;
    }

    public String getSubDomain() {
        return subDomain;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


}

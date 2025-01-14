package edu.bsu.cs222;
public class Revision {
    String username;
    String time;
    private String redirect = null;

    protected Revision(String username, String time){
        this.username = username;
        this.time = time;

    }
    protected String getRedirect(){
        return this.redirect;
    }
    protected void setRedirect(String redirectInput) {
        this.redirect = redirectInput;
    }

   @Override
   public String toString() {return String.format("%s\t%s", time, username);}
}

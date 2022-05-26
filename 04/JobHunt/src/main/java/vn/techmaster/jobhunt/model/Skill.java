package vn.techmaster.jobhunt.model;

public enum Skill {
    Java("Java"),
    CSharp("Csharp"),
    MySQL("MySQL"),
    Angular("Angular"),
    Python("Python"),
    Javascript("Javascript"),
    HTML_CSS("HTML CSS");
    public final String label;

    private Skill(String label) {
        this.label = label;
    }
    }

package sctec.enterprise.management.challenge.model.enums;
public enum Segment {
    TECHNOLOGY("Tecnologia"),
    COMMERCE("Comércio"),
    INDUSTRY("Indústria"),
    SERVICES("Serviços"),
    AGRIBUSINESS("Agronegócio");

    private final String description;

    Segment(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
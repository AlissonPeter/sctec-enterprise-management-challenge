package sctec.enterprise.management.challenge.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

    /**
     * Returns the enum description, including the JSON.
     * @return
     */
    @JsonValue
    public String getDescription() {
        return description;
    }

    /**
     * Make the POST request accept the enum description coming from a JSON object.
     * @return
     */
    @JsonCreator
    public static Segment fromDescription(String description) {
        for (Segment s : Segment.values()) {
            // Compara ignorando maiúsculas/minúsculas e espaços
            if (s.description.equalsIgnoreCase(description.trim())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Segmento inválido: " + description);
    }
}
package ie.atu.loginstoremicserpd.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long playerId;

    @NotBlank(message = "Player name cannot be left blank.") //PlayerName required
    private String playerName;

    @NotBlank(message = "Player email cannot be left blank.")
    @Email(message = "Player email must be a valid email.") //Forces a real email, while also giving an example in the field
    private String email;

    @NotBlank(message = "Player nickname cannot be left blank.") //Nickname required and must be unique (handled in service layer)
    private String nickname;

    private double credit = 0;
}

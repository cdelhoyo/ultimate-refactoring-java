package unit;

import signatureChange.Player;
import signatureChange.Role;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerShould {
    @Test
    public void increase_score_when_dragon_plays() throws Exception {
        Player player = new Player(Role.Dragon, "WhiteDragon", 0);

        player.play();

        assertThat(player.getScore()).isEqualTo(20);
    }

    @Test
    public void sets_the_initial_score() throws Exception {
        Player player = new Player(Role.Dragon, "WhiteDragon", 0);

        assertThat(player.getScore()).isEqualTo(0);
    }
}

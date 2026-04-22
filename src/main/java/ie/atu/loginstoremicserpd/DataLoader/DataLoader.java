package ie.atu.loginstoremicserpd.DataLoader;

import ie.atu.loginstoremicserpd.model.Player;
import ie.atu.loginstoremicserpd.repository.PlayerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(PlayerRepo playerRepo) {
        return args -> {
            if(playerRepo.count()==0){
                Player p1 = new Player();
                p1.setPlayerName("Paul");
                p1.setEmail("pd366@store.ie");
                p1.setNickname("Pd366");
                p1.setCredit(40.0);
                playerRepo.save(p1);

                Player p2 = new Player();
                p2.setPlayerName("Isabel");
                p2.setEmail("ir7@store.ie");
                p2.setNickname("Ir7");
                p2.setCredit(60.0);
                playerRepo.save(p2);
                System.out.println(" ~~~ Pre-made Player data loaded");
            }
        };
    }
}

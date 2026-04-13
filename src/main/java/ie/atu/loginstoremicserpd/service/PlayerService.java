package ie.atu.loginstoremicserpd.service;

import ie.atu.loginstoremicserpd.exception.NameConflictException;
import ie.atu.loginstoremicserpd.model.Player;
import ie.atu.loginstoremicserpd.repository.PlayerRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private List<Player> players;
    private final PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Player addPlayer(@Valid Player player){
        players = playerRepo.findAll();
        for(Player existing : players){
            if(existing.getNickname().equals(player.getNickname())){
                throw new NameConflictException("Player nickname already exists");
            }
        }
        playerRepo.save(player);
        return player;
    }

    public List<Player> getAllPlayers(){
        return playerRepo.findAll();
    }

    public Player getByPlayerId(long playerId){
        return playerRepo.getByPlayerId(playerId);
    }

    public List<Player> getByPlayerName(String playerName){
        return playerRepo.getByPlayerName(playerName);
    }

    public Player getPlayerByNickname(String nickname){
        return playerRepo.getByNickname(nickname);
    }
}

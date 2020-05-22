package chess.game.aspects;

import chess.game.aspects.pieces.Alliance;

public class Player {
    
    private Alliance alliance;

    public Player(Alliance alliance) {
        this.alliance = alliance;
    }

    public Alliance getAlliance() {
        return alliance;
    }
}
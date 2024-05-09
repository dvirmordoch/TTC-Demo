package com.dvir.demo.service;

import com.dvir.demo.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final Game game;

    public GameService(Game game) {
        this.game = game;
    }

}

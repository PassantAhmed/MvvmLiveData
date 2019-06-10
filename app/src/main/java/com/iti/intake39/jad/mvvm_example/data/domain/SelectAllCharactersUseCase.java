package com.iti.intake39.jad.mvvm_example.data.domain;

import android.arch.lifecycle.MutableLiveData;

import com.iti.intake39.jad.mvvm_example.data.AnimatedCharacterRepo;
import com.iti.intake39.jad.mvvm_example.data.AnimatedCharacterRepoImpl;
import com.iti.intake39.jad.mvvm_example.data.model.AnimatedCharacter;

import java.util.List;

public class SelectAllCharactersUseCase {

    private AnimatedCharacterRepo animatedCharacterRepo;

    public SelectAllCharactersUseCase(){
     animatedCharacterRepo = AnimatedCharacterRepoImpl.getInstance();
    }

    public MutableLiveData<List<AnimatedCharacter>> getAllAnimatedCharacters(){
        return animatedCharacterRepo.getCharacters();
    }
}

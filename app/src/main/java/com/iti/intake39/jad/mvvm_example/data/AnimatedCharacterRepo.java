package com.iti.intake39.jad.mvvm_example.data;

import android.arch.lifecycle.MutableLiveData;

import com.iti.intake39.jad.mvvm_example.data.model.AnimatedCharacter;

import java.util.List;

public interface AnimatedCharacterRepo {
    MutableLiveData<List<AnimatedCharacter>> getCharacters();
    void addCharacter(AnimatedCharacter animatedCharacter);
}

package com.iti.intake39.jad.mvvm_example.screens.listscreen;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;

import com.iti.intake39.jad.mvvm_example.data.domain.SelectAllCharactersUseCase;
import com.iti.intake39.jad.mvvm_example.data.model.AnimatedCharacter;

import java.util.List;

public class ListViewModel extends ViewModel {
    private MutableLiveData<List<AnimatedCharacter>> characters;
    private SelectAllCharactersUseCase allCharacters;
    private Observer<List<AnimatedCharacter>> listObserver;

    public ListViewModel(){
        allCharacters = new SelectAllCharactersUseCase();
        characters = allCharacters.getAllAnimatedCharacters();
        listObserver = animatedCharacters -> characters.postValue(animatedCharacters);
        characters.observeForever(listObserver);
    }

    public LiveData<List<AnimatedCharacter>> getCharacters(){
        return characters;
    }

    @Override
    protected void onCleared() {
        characters.removeObserver(listObserver);
        super.onCleared();
    }
}

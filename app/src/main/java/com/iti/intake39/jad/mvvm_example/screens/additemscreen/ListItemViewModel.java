package com.iti.intake39.jad.mvvm_example.screens.additemscreen;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.iti.intake39.jad.mvvm_example.data.domain.AddAnimatedCharacterUseCase;
import com.iti.intake39.jad.mvvm_example.data.model.AnimatedCharacter;

public class ListItemViewModel extends ViewModel {

    private AddAnimatedCharacterUseCase newCharacter;
    private MutableLiveData<Boolean> isCharactersUpdated = new MutableLiveData<>();

    public ListItemViewModel(){
        newCharacter = new AddAnimatedCharacterUseCase();
    }
    public void addNewCharacter(String characterName, String characterImg){
        isCharactersUpdated.setValue(true);
        addCharacter(characterName, characterImg);
    }

    private void addCharacter(final String characterName, final String characterImg){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                isCharactersUpdated.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    newCharacter.addAnimatedCharacter(new AnimatedCharacter(characterName,characterImg));
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<Boolean> getIsPlacesUpdating(){
        return isCharactersUpdated;
    }

}

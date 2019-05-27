package br.com.lucasfrancisco.exemplointroscreen;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import br.com.lucasfrancisco.exemplointroscreen.data.SPInfo;
import br.com.lucasfrancisco.exemplointroscreen.fragment.TermsConditionFragment;

public class IntroActivity extends MaterialIntroActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        verifyIntroActivity();

        String[] permissoes01 = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        String[] permissoes02 = {Manifest.permission.CAMERA};

        /////////////
        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.slide01)
                        .buttonsColor(R.color.botao_slide)
                        .title(getString(R.string.app_name))
                        .description(getString(R.string.app_name))
                        .image(R.drawable.ic_launcher_foreground)
                        .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showMessage(getString(R.string.app_name));
                    }
                }, getString(R.string.app_name)));

        //////////
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.slide02)
                .buttonsColor(R.color.botao_slide)
                .title(getString(R.string.app_name))
                .description(getString(R.string.app_name))
                .image(R.drawable.ic_launcher_foreground)
                .neededPermissions(permissoes01)
                .build());

        /////////////
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.slide03)
                .buttonsColor(R.color.botao_slide)
                .title(getString(R.string.app_name))
                .description(getString(R.string.app_name))
                .image(R.drawable.ic_launcher_foreground)
                .possiblePermissions(permissoes02)
                .build());


        addSlide(new TermsConditionFragment());
    }

    private void verifyIntroActivity() {
        if (new SPInfo(this).isIntroActivityShown()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}

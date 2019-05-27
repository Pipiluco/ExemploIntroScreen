package br.com.lucasfrancisco.exemplointroscreen.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import agency.tango.materialintroscreen.SlideFragment;
import br.com.lucasfrancisco.exemplointroscreen.MainActivity;
import br.com.lucasfrancisco.exemplointroscreen.R;
import br.com.lucasfrancisco.exemplointroscreen.data.SPInfo;

public class TermsConditionFragment extends SlideFragment {
    private CheckBox cbxTermo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terms_condition, container, false);
        cbxTermo = (CheckBox) view.findViewById(R.id.cbxTermo);
        return view;
    }

    @Override
    public String cantMoveFurtherErrorMessage() {
        return getActivity().getString(R.string.checkbox_erro);
    }

    @Override
    public boolean canMoveFurther() {
        if (cbxTermo.isChecked()) {
            new SPInfo(getActivity()).updateIntroStatus(true);

            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            getActivity().finish();
        }
        return cbxTermo.isChecked();
    }

    @Override
    public int backgroundColor() {
        return R.color.slide04;
    }

    @Override
    public int buttonsColor() {
        return R.color.botao_slide;
    }
}

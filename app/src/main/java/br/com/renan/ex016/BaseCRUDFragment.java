package br.com.renan.ex016;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.sql.SQLException;
import java.util.List;

import br.com.renan.ex016.controller.ICRUDDao;

/**
 * @author: renan santos carvalho
 */
public abstract class BaseCRUDFragment<T> extends Fragment {

    protected View view;

    protected BaseCRUDFragment() {
        super();
    }

    public abstract void findViews();

    public abstract int getFragmentId();

    public abstract void clearFields();

    public abstract TextView getResultTextview();

    public abstract ICRUDDao<T> getController();

    public abstract T viewToObject();

    public abstract void objectToView(T t);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(getFragmentId(), container, false);
        findViews();
        return view;
    }

    public void insert() {
        ICRUDDao<T> ctrl = getController();
        try {
            ctrl.insert(viewToObject());
            clearFields();
        } catch (SQLException e) {
            getResultTextview().setText(R.string.algo_deu_errado);
        }
    }

    public void update() {
        try {
            getController().update(viewToObject());
            clearFields();
        } catch (SQLException e) {
            getResultTextview().setText(R.string.algo_deu_errado);
        }
    }

    public void delete() {
        try {
            getController().delete(viewToObject());
            clearFields();
        } catch (SQLException e) {
            getResultTextview().setText(R.string.algo_deu_errado);
        }
    }

    public void findOne() {
        try {
            T one = getController().findOne(viewToObject());
            clearFields();
            objectToView(one);
        } catch (SQLException e) {
            getResultTextview().setText(R.string.algo_deu_errado);
        }
    }

    public void findAll() {
        try {
            List<T> all = getController().findAll();
            StringBuilder sb = new StringBuilder();
            for (T t : all) {
                sb.append(t);
                sb.append("\n");
            }
            sb.append("FIM");
            getResultTextview().setText(sb.toString());
        } catch (SQLException e) {
            getResultTextview().setText(R.string.algo_deu_errado);
        }
    }
}
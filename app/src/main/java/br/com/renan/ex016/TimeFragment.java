package br.com.renan.ex016;

import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.renan.ex016.controller.ICRUDDao;
import br.com.renan.ex016.controller.SafeParser;
import br.com.renan.ex016.model.Team;

public class TimeFragment extends BaseCRUDFragment<Team> {

    private Button btnBuscarT;
    private Button btnExcluirT;
    private Button btnListarT;
    private Button btnInserirT;
    private Button btnModificarT;
    private EditText etCodigoT;
    private EditText etCidadeT;
    private EditText etNomeT;
    private TextView tvResultT;

    public TimeFragment() {
        super();
    }

    @Override
    public void findViews() {
        btnBuscarT = view.findViewById(R.id.btnBuscarT);
        btnExcluirT = view.findViewById(R.id.btnExcluirT);
        btnListarT = view.findViewById(R.id.btnListarT);
        btnInserirT = view.findViewById(R.id.btnInserirT);
        btnModificarT = view.findViewById(R.id.btnModificarT);

        configureButtons();

        etCodigoT = view.findViewById(R.id.etCodigoT);
        etCidadeT = view.findViewById(R.id.etCidadeT);
        etNomeT = view.findViewById(R.id.etNomeT);

        tvResultT = view.findViewById(R.id.tvResultT);
        tvResultT.setMovementMethod(new ScrollingMovementMethod());
    }

    private void configureButtons() {
        btnBuscarT.setOnClickListener(e -> super.findOne());
        btnListarT.setOnClickListener(e -> super.findAll());
        btnInserirT.setOnClickListener(e -> super.insert());
        btnModificarT.setOnClickListener(e -> super.update());
        btnExcluirT.setOnClickListener(e -> super.delete());
    }

    @Override
    public int getFragmentId() {
        return R.layout.fragment_time;
    }

    @Override
    public void clearFields() {
        this.etCodigoT.setText("");
        this.etCidadeT.setText("");
        this.etNomeT.setText("");
    }

    @Override
    public TextView getResultTextview() {
        return tvResultT;
    }

    @Override
    public ICRUDDao<Team> getController() {
        return null;
    }

    @Override
    public Team viewToObject() {
        int cod = SafeParser.safeParseInt(this.etCodigoT.getText().toString(), -1);
        String c = this.etCidadeT.getText().toString();
        String n = this.etNomeT.getText().toString();
        return new Team(cod, n, c);
    }

    @Override
    public void objectToView(Team team) {
        this.etCodigoT.setText(team.getCode());
        this.etCidadeT.setText(team.getCity());
        this.etNomeT.setText(team.getName());
    }
}
package br.com.renan.ex016;

import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.LocalDate;

import br.com.renan.ex016.controller.ICRUDDao;
import br.com.renan.ex016.controller.SafeParser;
import br.com.renan.ex016.model.Player;

/**
 * @author: renan santos carvalho
 */
public class JogadorFragment extends BaseCRUDFragment<Player> {

    private Button btnBuscarJ;
    private Button btnExcluirJ;
    private Button btnListarJ;
    private Button btnInserirJ;
    private Button btnModificarJ;

    private EditText etIdJ;
    private EditText etNascimentoJ;
    private EditText etName;
    private EditText etAlturaJ;
    private EditText etPesoJ;

    private TextView tvResultJ;
    private Spinner spTimeJ;

    public JogadorFragment() {
        super();
    }

    @Override
    public void findViews() {
        btnBuscarJ = view.findViewById(R.id.btnBuscarJ);
        btnExcluirJ = view.findViewById(R.id.btnExcluirJ);
        btnListarJ = view.findViewById(R.id.btnListarJ);
        btnInserirJ = view.findViewById(R.id.btnInserirJ);
        btnModificarJ = view.findViewById(R.id.btnModificarJ);

        configureButtons();

        etIdJ = view.findViewById(R.id.etIdJ);
        etNascimentoJ = view.findViewById(R.id.etNascimentoJ);
        etName = view.findViewById(R.id.etName);
        etAlturaJ = view.findViewById(R.id.etAlturaJ);
        etPesoJ = view.findViewById(R.id.etPesoJ);

        tvResultJ = view.findViewById(R.id.tvResultJ);
        tvResultJ.setMovementMethod(new ScrollingMovementMethod());

        spTimeJ = view.findViewById(R.id.spTimeJ);

    }

    private void configureButtons() {
        btnBuscarJ.setOnClickListener(e -> super.findOne());
        btnListarJ.setOnClickListener(e -> super.findAll());
        btnInserirJ.setOnClickListener(e -> super.insert());
        btnModificarJ.setOnClickListener(e -> super.update());
        btnExcluirJ.setOnClickListener(e -> super.delete());
    }

    @Override
    public int getFragmentId() {
        return R.layout.fragment_jogador;
    }

    @Override
    public void clearFields() {
        this.etIdJ.setText("");
        this.etNascimentoJ.setText("");
        this.etName.setText("");
        this.etAlturaJ.setText("");
        this.etPesoJ.setText("");
    }

    @Override
    public TextView getResultTextview() {
        return tvResultJ;
    }

    @Override
    public ICRUDDao<Player> getController() {
        return null;
    }

    @Override
    public Player viewToObject() {
        int id = SafeParser.safeParseInt(this.etIdJ.getText().toString(), -1);
        LocalDate ns = LocalDate.parse(this.etNascimentoJ.getText().toString());
        String name = this.etName.getText().toString();
        float h = SafeParser.safeParseFloat(this.etAlturaJ.getText().toString(), -1);
        float w = SafeParser.safeParseFloat(this.etPesoJ.getText().toString(), -1);

        //TODO: trabalhar com o spinner

        return new Player(id, name, ns, h, w, null);
    }

    @Override
    public void objectToView(Player player) {
        this.etIdJ.setText(player.getId());
        this.etNascimentoJ.setText(player.getBirthDate().toString());
        this.etName.setText(player.getName());
        this.etAlturaJ.setText(String.valueOf(player.getHeight()));
        this.etPesoJ.setText(String.valueOf(player.getWeight()));

    }
}
package com.neto.deolino.sistemadecadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity {

    private ArrayList<Registro> arrayRegistros;
    TelaPrincipal telaPrincipal;
    TelaCadastroUsuario telaCadastro;
    TelaListagemUsuarios telaListagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cadastro);

        arrayRegistros = new ArrayList<Registro>();

        telaPrincipal = new TelaPrincipal(this);
        telaCadastro = new TelaCadastroUsuario(this, telaPrincipal);
        telaListagem = new TelaListagemUsuarios(this, telaPrincipal);

        telaPrincipal.setTelaCadastro(telaCadastro);
        telaPrincipal.setTelaListagem(telaListagem);

        telaPrincipal.CarregarTela();
    }

    public ArrayList<Registro> getRegistros() {
        return arrayRegistros;
    }

    public void ExibirMensagem(String msg) {
        AlertDialog.Builder d = new AlertDialog.Builder(CadastroActivity.this);
        d.setTitle("Aviso");
        d.setMessage(msg);
        d.setNeutralButton("OK", null);
        d.show();
    }
}

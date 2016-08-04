package com.neto.deolino.sistemadecadastro;

import android.app.*;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by deolino on 03/08/16.
 */
public class TelaCadastroUsuario {
    CadastroActivity act;

    EditText edNome, edEndereco, edTelefone;
    Button btCadastrar, btCancelarCadastro;

    TelaPrincipal telaPrincipal;

    public TelaCadastroUsuario(CadastroActivity act, TelaPrincipal telaPrincipal) {
        this.act = act;
        this.telaPrincipal = telaPrincipal;
    }

    public void CarregarTela() {
        act.setContentView(R.layout.cadastro_de_usuario);

        edNome = (EditText) act.findViewById(R.id.ednome);
        edTelefone = (EditText) act.findViewById(R.id.edtelefone);
        edEndereco = (EditText) act.findViewById(R.id.edendereco);

        btCadastrar = (Button) act.findViewById(R.id.btcadastrar);
        btCancelarCadastro = (Button) act.findViewById(R.id.btcancelar_cadastro);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar usuário ?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nome = edNome.getText().toString();
                        String telefone = edTelefone.getText().toString();
                        String endereco = edEndereco.getText().toString();
                        act.getRegistros().add(new Registro(nome,telefone,endereco));
                        act.ExibirMensagem("Cadastro efetuado com sucesso.");

                        telaPrincipal.CarregarTela();
                    }
                });
                dialogo.show();
            }
        });

        btCancelarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
            dialogo.setTitle("Aviso");
            dialogo.setMessage("Sair do cadastro?");
            dialogo.setNegativeButton("Não", null);
            dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog,
                                   int which) {
                   telaPrincipal.CarregarTela();
                }
            });
            dialogo.show();
           }
       });
    }
}

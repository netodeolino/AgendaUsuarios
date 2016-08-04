package com.neto.deolino.sistemadecadastro;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by deolino on 03/08/16.
 */
public class TelaListagemUsuarios {
    CadastroActivity act;

    TelaPrincipal telaPrincipal;
    Button btAnterior, btProximo, btFechar;
    TextView txtNome, txtTelefone, txtEndereco, txtStatus;
    int index;

    public TelaListagemUsuarios(CadastroActivity act, TelaPrincipal telaPrincipal) {
        this.act = act;
        this.telaPrincipal = telaPrincipal;
        index = 0;
    }

    public void CarregarTela()
    {
        //Antes de carregar a tela, verifica se existe registros inseridos
        if(act.getRegistros().size() == 0)
        {
            (new AlertDialog.Builder(act))
                    .setTitle("Aviso")
                    .setMessage("Não existe nenhum Usuário cadastrado!")
                    .setNeutralButton("OK", null)
                    .show();
            return;
        }

        act.setContentView(R.layout.listagem_usuarios_cadastros);

        btAnterior = (Button) act.findViewById(R.id.btanterior);
        btProximo = (Button) act.findViewById(R.id.btproximo);
        btFechar = (Button) act.findViewById(R.id.btfechar);

        txtNome = (TextView) act.findViewById(R.id.txtnome);
        txtEndereco = (TextView) act.findViewById(R.id.txtendereco);
        txtTelefone = (TextView) act.findViewById(R.id.txttelefone);
        txtStatus = (TextView) act.findViewById(R.id.txtstatus);

        PreencheCampos(index);
        AtualizaStatus(index);

        btAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index > 0) {
                    index--;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });

        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index < act.getRegistros().size() - 1) {
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });

        btFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaPrincipal.CarregarTela();
            }
        });
    }

    private void PreencheCampos(int idx) {
        txtNome.setText(act.getRegistros().get(idx).getNome());
        txtTelefone.setText(act.getRegistros().get(idx).getTelefone());
        txtEndereco.setText(act.getRegistros().get(idx).getEndereco());
    }

    private void AtualizaStatus(int idx) {
        int total = act.getRegistros().size();
        txtStatus.setText("Registros : " + (idx+1) + "/" + total);
    }
}

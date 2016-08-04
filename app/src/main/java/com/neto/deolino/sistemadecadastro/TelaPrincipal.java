package com.neto.deolino.sistemadecadastro;

import android.view.View;
import android.widget.Button;

/**
 * Created by deolino on 03/08/16.
 */
public class TelaPrincipal {
    CadastroActivity act;

    Button btCadastrarUsuario;
    Button btListarUsuariosCadastrados;
    TelaCadastroUsuario telaCadastro;
    TelaListagemUsuarios telaListagem;

    public TelaPrincipal(CadastroActivity act) {
        this.act = act;
    }

    public void CarregarTela() {
        act.setContentView(R.layout.activity_cadastro);

        btCadastrarUsuario = (Button) act.findViewById(R.id.btcadastrar_usuario);
        btListarUsuariosCadastrados = (Button) act.findViewById(R.id.bt_listar_usuarios_cadastrados);

        btCadastrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaCadastro.CarregarTela();
            }
        });

        btListarUsuariosCadastrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaListagem.CarregarTela();
            }
        });
    }

    public void setTelaCadastro(TelaCadastroUsuario tela_cadastro) {
        this.telaCadastro = tela_cadastro;
    }

    public void setTelaListagem(TelaListagemUsuarios tela_listagem) {
        this.telaListagem = tela_listagem;
    }
}

package com.laboratorio.laboratorionassau.controller;

import com.laboratorio.laboratorionassau.service.agendaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;

import com.laboratorio.laboratorionassau.model.agenda;


@RestControllerEndpoint(id = "")
@RequestMapping("/api/v1")
public class Agendacontroller {

    @Autowired
    private agendaService agendaService;

    @PostMapping("/cad_agend")
    public Response cadastaragendamento(@Valid @RequestBody Agendamento agendamento){
        
        String turno_agenda_banco = agendamentoDAO.findturnoagendamento(agendamento.getTurno(),agendamento.getData_agendamento());
        System.out.println("Turno agendamento banco: " + turno_agendamento_banco );

        LocalDate data_agenda_banco = agendamentoDAO.findDataAgendamento(agendamento.getTurno(),agendamento.getData_agendamento());
        System.out.println("Data agendamento banco: " + data_agendamento_banco );


        if((turno_agenda_banco == null && data_agenda_banco == null) || (turno_agenda_banco == null && data_agenda_banco == agendamento.getData_agendamento()) || (turno_agenda_banco == agendamento.getTurno() && data_agenda_banco == agendamento.getData_agendamento()) || (turno_agenda_banco == agendamento.getTurno() && data_agenda_banco == null)){
            this.agendamentoDAO.save(agendamento);
            int status = 200;
            String message = "Agendamento cadastrado com sucesso.";
            return new Response(status, message);
        }else{
            int status = 409;
            String message = "Agendamento já cadastrado.";
            return new Response(status, message);
        }
    }


    @PostMapping("/exibir_agendamento")
    public List<ResponseAgendamentoGet> exibirnomefuncionario(@Valid @RequestBody Agendamento agendamento){
        Funcionario funcionario = agendamento.getFuncionario();
        Long convertInteger = funcionario.getMatricula();

        List<LocalDate> datasAgendamento = agendamentoDAO.findDataAgendamentoFunc(convertInteger);
        System.out.println("datasAgendamento: " + datasAgendamento);

        List<String> turnos = agendamentoDAO.findTurnoAgendamentoFunc(convertInteger);
        System.out.println("turnos: " + turnos);

        List<ResponseAgendamentoGet> responseList = new ArrayList<>();
        for (int i = 0; i < datasAgendamento.size(); i++) {
            ResponseAgendamentoGet response = new ResponseAgendamentoGet(turnos.get(i), datasAgendamento.get(i));
            responseList.add(response);
        }
        return responseList;
    }

    @DeleteMapping("/delet_agend/{idAgendamento}")
    public Response deleteFuncionario(@PathVariable Long idAgendamento, Agendamento agendamento){
        Long id_agendamento_banco = agendamentoDAO.findAgendamento(agendamento.getIdAgendamento());
        System.out.println("Matricula delete no banco: " + id_agendamento_banco);
        if(id_agendamento_banco == null){
            int status = 409;
            String message = "Agendamento não encontrado";
            return new Response(status, message);
        }else{
            agendamentoService.deleteagend(idAgendamento);
            int status = 200;
            String message = "Agendamento deletado com sucesso";
            return new Response(status, message);
        }
    }
}


}

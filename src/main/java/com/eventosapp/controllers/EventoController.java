package com.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.models.Convidado;
import com.eventosapp.models.Evento;
import com.eventosapp.repository.ConvidadoRepository;
import com.eventosapp.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private ConvidadoRepository cr;
	
	@Autowired
	private EventoRepository er;
	
	
    @RequestMapping (value="/casdastrarEvento", method=RequestMethod.GET)
    public String form (){
        return "evento/formEvento";
    }
    
    @RequestMapping (value="/casdastrarEvento", method=RequestMethod.POST)
    public String form (Evento evento){
    	
    	er.save(evento);
    	
        return "redirect:/cadastrarEvento";
    }
    
    @RequestMapping("/eventos")
    public ModelAndView listaEventos() {
    	ModelAndView mv = new ModelAndView("index");
    	Iterable<Evento> eventos = er.findAll();
    	mv.addObject("eventos", eventos);
    	return mv;
    }
    
    @RequestMapping(value= "/{codigo}",method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo")long codigo) {
    	Evento evento = er.findByCodigo(codigo);
    	ModelAndView mv = new ModelAndView("evento/detalhesEvento");
    	mv.addObject("evento", evento);
    	
    	Iterable<Convidado> convidados = cr.findByEvento(evento);
    	mv.addObject("convidados", convidados);
       	return mv;
    }
    
    @RequestMapping(value= "/{codigo}",method=RequestMethod.POST)
    public String detalhesEventoPost(@PathVariable("codigo")long codigo, Convidado convidado) {
    	Evento evento = er.findByCodigo(codigo);
    	convidado.setEvento(evento);
    	cr.save(convidado);
    	
    	return "redirect:/{codigo}";
    }
}

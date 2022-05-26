package com.fiap.luccas.bean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.model.file.UploadedFile;

import com.fiap.luccas.dao.SerieDao;
import com.fiap.luccas.model.Serie;

@Named
@RequestScoped
public class SerieBean {
	
	private Serie serie = new Serie();
	private List<Serie>  list;
	private UploadedFile image;
	
	private SerieDao serieDao = new SerieDao();
	
	public SerieBean() {
		list = this.list();
	}
	
	public String save() throws IOException {
		System.out.println(this.serie);
		
		System.out.println(image.getFileName());
		
		ServletContext servletContext = (ServletContext) FacesContext.
				getCurrentInstance().
				getExternalContext().
				getContext();
		String servletPath = servletContext.getRealPath("/");
		
		System.err.println(servletPath);
		
		FileOutputStream out = new FileOutputStream(servletPath + "//images//" + image.getFileName());
		out.write(image.getContent());
		out.close();
		
		serie.setImagePath("//images" + image.getFileName());
		
		serieDao.create(serie);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Serie cadastrada com sucesso"));
		return "series";
	}
	
	public List<Serie> list() {
		return serieDao.listAll();
	}
	
	public String delete(Serie serie) {
		 FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		 
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Serie apagada com sucesso"));
		 
		 return "serie?faces-redidrect=true";
	}
	
	public void edit() {
		serieDao.update(serie);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Serie atualizada com sucesso"));
		
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<Serie> getList() {
		return list;
	}

	public void setList(List<Serie> list) {
		this.list = list;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}
	
	

}

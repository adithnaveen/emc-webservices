package emc.service;

import javax.jws.WebService;

import emc.model.Picture;

@WebService
public interface PictureService {
	public Picture getPicture(String shortName);
}

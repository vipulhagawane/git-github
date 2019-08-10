package com.dhyanpraveshika.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dhyanpraveshika.model.DPSVideo;

public interface DPSVideoService {

	boolean addVideo(HttpServletRequest request);

	List<DPSVideo> getVideoes();

}

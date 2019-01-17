package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.NameModifiedException;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistException, TrackAlreadyExistException;
    public List<Track> getAllTracks() throws Exception;
    public Boolean deleteTrack(int id) throws TrackNotFoundException, TrackNotFoundException;
//    public List<Track> searchTrack(String name) throws TrackNotFoundException;
    public Track updateComment(Track track) throws TrackNotFoundException, NameModifiedException;
}

package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.NameModifiedException;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackDBServiceImpl implements TrackService {


    private TrackRepository trackRepository;
    @Autowired
    public TrackDBServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistException {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistException("Track already exist with id" + track.getId());
        }
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTracks() throws Exception{
        List<Track> trackList = (List<Track>) trackRepository.findAll();
        return trackList;
    }

    @Override
    public Boolean deleteTrack(int id) throws TrackNotFoundException {
        if (!trackRepository.existsById(id)) {
            throw new TrackNotFoundException("Track with " + id + " doesnot exist");
        }
        trackRepository.deleteById(id);
        return true;
    }
//    @Override
//    public List<Track> searchTrack(String name) throws TrackNotFoundException{
//        if (trackRepository.findByName(name).size() == 0) {
//            throw new TrackNotFoundException("Track with " + name + " doesnot exist");
//        }
//        return trackRepository.findByName(name);
//    }


    @Override
    public Track updateComment(Track track) throws TrackNotFoundException, NameModifiedException {
        if (!trackRepository.existsById(track.getId())) {
            throw new TrackNotFoundException("Track with " + track.getId() + " doesnot exist");
        }
        Optional<Track> tempTrack =  trackRepository.findById(track.getId());
        if (!track.getName().equals(tempTrack.get().getName())) {
            throw new NameModifiedException("Name of track can not be modified");
        }
        if (tempTrack.isPresent()) {
            tempTrack.get().setComment(track.getComment());
            return trackRepository.save(tempTrack.get());
        } else {
            return null;
        }
    }


}

package com.stackroute.controller;

import com.stackroute.exception.NameModifiedException;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//Use an interface that can be implemented by UserService and UserAWSService
@RequestMapping("/api/v1/")
@Api(value = "Muzix APP", description = "Operations pertaining to employee in Employee Management System")
public class TrackController {


    private TrackService trackService;

    // autowired must be used on constructor
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    @ApiOperation(value = "Save a track")
    @PostMapping(value = "track")
    public ResponseEntity<?> saveTrack( @ApiParam(value = "Track will be saved in database" +
            " table", required = true)@RequestBody Track track) throws TrackAlreadyExistException {
//        try {
            return new ResponseEntity<Track>(trackService.saveTrack(track), HttpStatus.OK);
//        } catch (TrackAlreadyExistException e) {
//            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
//        } catch (Exception e) {
//            return new ResponseEntity<String>("Exception occurred" + e, HttpStatus.BAD_REQUEST);
//        }
    }
    @ApiOperation(value = "List of track")
    @GetMapping(value = "tracks")
    public ResponseEntity<?> listOfTrack() throws Exception{
//        try {
            List<Track> allTracks = trackService.getAllTracks();
            return new ResponseEntity<List<Track>>(allTracks, HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<String>("Exception Occurred: " + e, HttpStatus.BAD_REQUEST);
//        }

    }
    @ApiOperation(value = "Delete a track")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteTrack( @ApiParam(value = "Track with Id will be deleted from database " +
            "table", required = true)@PathVariable("id") String id) throws TrackNotFoundException {
//        try {
            return new ResponseEntity<Boolean>(trackService.deleteTrack(Integer.parseInt(id)), HttpStatus.OK);
//        } catch (TrackNotFoundException e) {
//            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
//        } catch (Exception e) {
//            return new ResponseEntity<String>("Exception Occurred: " + e, HttpStatus.BAD_REQUEST);
//        }

    }
    @ApiOperation(value = "Update a track")
    @PostMapping(value = "{id}")
    public ResponseEntity<?> updateComment( @ApiParam(value = "Track with Id will be updated in database " +
            "table", required = true)@RequestBody Track track) throws TrackNotFoundException, NameModifiedException{
//        try {
            return new ResponseEntity<Track>(trackService.updateComment(track), HttpStatus.OK);
//        } catch (TrackNotFoundException e) {
//            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
//        } catch (NameModifiedException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//        } catch (Exception e) {
//            return new ResponseEntity<String>("Exception Occurred: " + e, HttpStatus.BAD_REQUEST);
//        }
    }
//    @ApiOperation(value = "Serach a track")
//    @GetMapping(value = "{name}")
//    public ResponseEntity<?> searchTrack( @ApiParam(value = "Traack with Id is searched in database " +
//            "table", required = true)@PathVariable String name) throws TrackNotFoundException{
////        try {
//            return new ResponseEntity<List<Track>>(trackService.searchTrack(name), HttpStatus.OK);
////        } catch (TrackNotFoundException e) {
////            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
////        } catch (Exception e) {
////            return new ResponseEntity<String>("Exception Occurred: " + e, HttpStatus.BAD_REQUEST);
////        }
//
//    }
}

package com.ucalp.sempar.service.impl;

import com.ucalp.sempar.converter.rq.StationRqConverter;
import com.ucalp.sempar.converter.rs.StationRsConverter;
import com.ucalp.sempar.dto.rq.StationRqDTO;
import com.ucalp.sempar.dto.rs.StationRsDTO;
import com.ucalp.sempar.entity.Locality;
import com.ucalp.sempar.entity.Station;
import com.ucalp.sempar.enums.ErrorType;
import com.ucalp.sempar.exception.BaseException;
import com.ucalp.sempar.exception.InvalidRequestException;
import com.ucalp.sempar.repository.LocalitiesRepository;
import com.ucalp.sempar.repository.StationsRepository;
import com.ucalp.sempar.service.StationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StationsServiceImpl implements StationsService {

    private final StationsRepository stationsRepository;
    private final LocalitiesRepository localitiesRepository;
    private final StationRqConverter stationRqConverter;
    private final StationRsConverter stationRsConverter;

    @Autowired
    private StationsServiceImpl(final StationsRepository stationsRepository,
                                final LocalitiesRepository localitiesRepository,
                                final StationRqConverter stationRqConverter,
                                final StationRsConverter stationRsConverter) {
        this.stationsRepository = stationsRepository;
        this.localitiesRepository = localitiesRepository;
        this.stationRqConverter = stationRqConverter;
        this.stationRsConverter = stationRsConverter;
    }

    @Override
    public StationRsDTO createStation(final StationRqDTO stationData) throws BaseException {
        final Optional<Locality> searchedLocality = this.localitiesRepository.findById(stationData.getLocalityId());
        if (searchedLocality.isPresent()) {
            final Station convertedStation = this.stationRqConverter.convert(stationData);
            convertedStation.setLocality(searchedLocality.get());
            final Station savedStation = this.stationsRepository.save(convertedStation);
            return this.stationRsConverter.convert(savedStation);
        } else {
            throw new InvalidRequestException(ErrorType.STATION_INVALID_REQUEST, "Locality does not exist");
        }
    }

}

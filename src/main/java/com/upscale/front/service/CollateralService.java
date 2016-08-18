package com.upscale.front.service;

import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upscale.front.domain.Collateral;
import com.upscale.front.domain.Tenant;
import com.upscale.front.repository.CollateralRepository;

/**
 * 
 * @author Anurag Garg
 *
 */

@Service
@Transactional
public class CollateralService {
	
	private final Logger log = LoggerFactory.getLogger(CollateralService.class);

	@Inject
	private CollateralRepository collateralRepository;

	public Collateral save(Collateral collateral) {
		log.debug("Request to save Collateral : {}", collateral);
		Collateral result = collateralRepository.saveAndFlush(collateral);
		return result;
	}

	@Transactional(readOnly = true)
	public Page<Collateral> findAll(Pageable pageable) {
		log.debug("Request to get all Collaterals");
		Page<Collateral> result = collateralRepository.findAll(pageable);
		return result;
	}

	@Transactional(readOnly = true)
	public Collateral findOne(Long id) {
		log.debug("Request to get collateral : {}", id);
		Collateral collateral = collateralRepository.findOne(id);
		return collateral;
	}

	@Transactional(readOnly = true)
	public Collateral findCollateralByTenantAndName(Tenant tenant, String name) {
		log.debug("Request to get collateral by Tenant and Name : {}", tenant.getTenant(), name);
		Optional<Collateral> collateral = collateralRepository.findCollateralByTenantAndName(tenant, name);
		return collateral.get();
	}
	public void delete(Long id) {
		log.debug("Request to delete Collateral : {}", id);
		collateralRepository.delete(id);
	}
}

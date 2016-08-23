package in.cozynest.cozyapis.utils;

import in.cozynest.cozyapis.exception.UnauthorizedException;

public class Authorize {

	public boolean isUserAuthorized(String generatedUserId, String authId) {
		if(!generatedUserId.equals(authId))
			throw new UnauthorizedException("Request forbidden");
		return true;
	}
}

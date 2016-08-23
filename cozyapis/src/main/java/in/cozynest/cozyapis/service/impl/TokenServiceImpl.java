package in.cozynest.cozyapis.service.impl;

import java.util.ArrayList;

import in.cozynest.cozyapis.dao.ITokenDao;
import in.cozynest.cozyapis.dao.impl.TokenDaoImpl;
import in.cozynest.cozyapis.model.Token;
import in.cozynest.cozyapis.service.ITokenService;

public class TokenServiceImpl implements ITokenService {

	ITokenDao tokenDao=new TokenDaoImpl();
	
		
	@Override
	public long count() {
		
		return tokenDao.count() ;
	}

	@Override
	public Token create(Token token) {
		
		return tokenDao.create(token);
	}

	@Override
	public Token update(Token token) {
		
		return tokenDao.update(token);
	}

	@Override
	public void delete(Token token) {
		
        tokenDao.delete(token);
	}

	@Override
	public ArrayList<Token> findAll() {
		
		return tokenDao.findAll();
	}

	@Override
	public Token findById(int id) {
		
		return tokenDao.findById(id);
	}
	
	@Override
	public Token findByAccessToken(String token) {
		
		return tokenDao.findByAccessToken(token);
	}

}
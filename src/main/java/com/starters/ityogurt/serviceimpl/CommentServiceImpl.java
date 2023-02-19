package com.starters.ityogurt.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starters.ityogurt.dao.CommentDAO;
import com.starters.ityogurt.service.CommentService;

@Service("commentservice")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentDAO dao;

	@Override
	public void deleteComment(int userSeq) {
		dao.deleteComment(userSeq);
	}
	
}

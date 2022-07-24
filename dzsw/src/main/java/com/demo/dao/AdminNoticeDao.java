package com.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demo.entity.Notice;
@Repository("adminNoticeDao")
@Mapper
public interface AdminNoticeDao {

  public List<Notice> selectAllNotices();
  public int addNotice(Notice notice);
  public int deleteNotice(String noticeid);
public int deleteNotices(List<String> list);
public List<Notice> selectAllNoticesByPage(Map  map);
public Notice selectNoticeById(String noticeid);

}

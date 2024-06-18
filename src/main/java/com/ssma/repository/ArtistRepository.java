package com.ssma.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssma.vo.Artist;

@Mapper
public interface ArtistRepository {

	@Insert("""
			INSERT INTO
			artist SET
			regDate = NOW(),
			updateDate = NOW(),
			`name` = #{name},
			`gender` = #{gender},
			`birth`= #{birth}
			""")
	public void writeArtist(String name, String gender, String birth);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

	@Select("""
			SELECT *
			FROM artist
			WHERE id = #{id}
			""")
	public Artist getArtist(int id);
	
	@Select("""
			SELECT * from artist
			""")
	public List<Artist> getArtists();


	@Delete("DELETE FROM Artist WHERE id = #{id}")
	public void deleteArtist(int id);

	@Update("""
			UPDATE Artist
			SET title = #{title},
			`body` = #{body},
			updateDate = NOW()
			WHERE id = #{id}
				""")
	public void modifyArtist(int id, String title, String body);
	
	@Select("""
			<script>
			SELECT A.*, M.nickname AS extra__writer, IFNULL(COUNT(R.id),0) AS extra__repliesCnt
			FROM Artist AS A
			INNER JOIN `member` AS M
			ON A.memberId = M.id
			LEFT JOIN `reply` AS R
			ON A.id = R.relId
			WHERE 1
			<if test="boardId != 0">
				AND A.boardId = #{boardId}
			</if>
			<if test="searchKeyword != ''">
				<choose>
					<when test = "searchKeywordTypeCode == 'title'">
						AND A.title LIKE CONCAT('%',#{searchKeyword},'%')
					</when>
					<when test = "searchKeywordTypeCode == 'extra__writer'">
						AND M.nickname LIKE CONCAT('%',#{searchKeyword},'%')
					</when>
					<when test="searchKeywordTypeCode == 'body'">
						AND A.`body` LIKE CONCAT('%',#{searchKeyword},'%')
					</when>
					<otherwise>
						AND A.title LIKE CONCAT('%',#{searchKeyword},'%')
						OR A.body LIKE CONCAT('%',#{searchKeyword},'%')
					</otherwise>
					</choose>
			</if>
			GROUP BY A.id
			ORDER BY A.id DESC
			<if test="limitFrom >= 0 ">
				LIMIT #{limitFrom}, #{limitTake}
			</if>

			</script>
			""")
	public List<Artist> getForPrintArtists(int boardId, int limitFrom, int limitTake, String searchKeywordTypeCode,
			String searchKeyword);

	@Select("""
			<script>
			SELECT COUNT(*) AS cnt
			FROM Artist AS A
			INNER JOIN `member` AS M
			ON A.memberId = M.id
			WHERE 1
			<if test="boardId != 0">
				AND boardId = #{boardId}
			</if>
			<if test="searchKeyword != ''">
				<choose>
					<when test="searchKeywordTypeCode == 'title'">
						AND A.title LIKE CONCAT('%',#{searchKeyword},'%')
					</when>
					<when test = "searchKeywordTypeCode == 'extra__writer'">
						AND M.nickname LIKE CONCAT('%',#{searchKeyword},'%')
					</when>
					<when test="searchKeywordTypeCode == 'body'">
						AND A.body LIKE CONCAT('%',#{searchKeyword},'%')
					</when>
					<otherwise>
						AND A.title LIKE CONCAT('%',#{searchKeyword},'%')
						OR A.body LIKE CONCAT('%',#{searchKeyword},'%')
					</otherwise>
				</choose>
			</if>
			ORDER BY A.id DESC
			</script>
			""")
	public int getArtistsCount(Integer boardId, String searchKeywordTypeCode, String searchKeyword);
}

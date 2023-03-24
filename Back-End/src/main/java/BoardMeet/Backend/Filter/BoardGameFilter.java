package BoardMeet.Backend.Filter;

import BoardMeet.Backend.Model.BoardGame;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class BoardGameFilter implements Specification<BoardGame> {

    private String name;
    private String genre;
    private String authorsGame;
    private  String artists;
    private String publishers;
    private Double ratingUser;
    private  Integer rangeOfPlayersMin;
    private  Integer rangeOfPlayersMax;
    private  String sortBy;
    private String sortDirection;


    @Override
    public Predicate toPredicate(Root<BoardGame> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotBlank(name))
        {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        }
        if (StringUtils.isNotBlank(genre))
        {
            predicates.add(criteriaBuilder.equal(root.get("genre"), genre));
        }
        if (StringUtils.isNotBlank(authorsGame))
        {
            predicates.add(criteriaBuilder.like(root.get("authorsGame"),  "%" + authorsGame + "%"));
        }
        if (StringUtils.isNotBlank(artists))
        {
            predicates.add(criteriaBuilder.like(root.get("artists"), "%" + artists + "%"));
        }
        if (StringUtils.isNotBlank(publishers))
        {
            predicates.add(criteriaBuilder.like(root.get("publishers"),  "%" + publishers + "%"));
        }
        if(ratingUser!=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("ratingUser"),ratingUser));
        }
        if(rangeOfPlayersMax!=null){
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("rangeOfPlayersMax"),rangeOfPlayersMax));
        }
        if(rangeOfPlayersMin!=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rangeOfPlayersMin"),rangeOfPlayersMin));
        }
        try {
            if (StringUtils.isNotBlank(sortBy)) {
                if (StringUtils.isNotBlank(sortDirection)) {
                    if (sortDirection.equals("DESC")) {
                        query.orderBy(criteriaBuilder.desc(root.get(sortBy)));
                    } else if (sortDirection.equals("ASC")) {
                        query.orderBy(criteriaBuilder.asc(root.get(sortBy)));
                    }
                } else {
                    query.orderBy(criteriaBuilder.desc(root.get(sortBy)));
                }
            }
        }catch (IllegalArgumentException e){
        }

        return predicates.size() <= 0 ? null : criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthorsGame() {
        return authorsGame;
    }

    public void setAuthorsGame(String authorsGame) {
        this.authorsGame = authorsGame;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public Double getRatingUser() {
        return ratingUser;
    }

    public void setRatingUser(Double ratingUser) {
        this.ratingUser = ratingUser;
    }

    public Integer getRangeOfPlayersMin() {
        return rangeOfPlayersMin;
    }

    public void setRangeOfPlayersMin(Integer rangeOfPlayersMin) {
        this.rangeOfPlayersMin = rangeOfPlayersMin;
    }

    public Integer getRangeOfPlayersMax() {
        return rangeOfPlayersMax;
    }

    public void setRangeOfPlayersMax(Integer rangeOfPlayersMax) {
        this.rangeOfPlayersMax = rangeOfPlayersMax;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }
}

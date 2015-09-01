package demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.IlJugMember;
import demo.service.IIlJugMemberService;

@RestController
@RequestMapping("/iljugmembers")
@Api(value = "/iljugmembers")
public class IlJugMemberController {

	@Autowired
	IIlJugMemberService ilJugMemberService;

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = { "application/json" })
	@ApiOperation(value = "Create a new IL JUG Member", notes = "Returns the newly created IL JUG Member", response = IlJugMember.class)
	public ResponseEntity<IlJugMember> post(
			@ApiParam(value = "Last name of IL JUG Member", required = true) @RequestParam(value = "last", required = true) String lastName,
			@ApiParam(value = "First name of IL JUG Member", required = true) @RequestParam(value = "first", required = true) String firstName) {
		IlJugMember ilJugMember = ilJugMemberService.createIlJugMember(
				lastName, firstName);
		return new ResponseEntity<IlJugMember>(ilJugMember, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update an IL JUG Member details", notes = "Updates an IL JUG Member first/last name details")
	public void put(
			@ApiParam(value = "ID of the IL JUG Member", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "Last name of IL JUG Member", required = true) @RequestParam(value = "last", required = true) String lastName,
			@ApiParam(value = "First name of IL JUG Member", required = true) @RequestParam(value = "first", required = true) String firstName) {
		ilJugMemberService.updateIlJugMember(id, lastName, firstName);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ApiOperation(value = "Find IL JUG Member by ID", notes = "Returns the IL JUG Member found")
	public IlJugMember getIJugMemberById(
			@ApiParam(value = "ID of the IL JUG Member", required = true) @PathVariable("id") Long id) {
		return ilJugMemberService.getIlJugMember(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" })
	@ApiOperation(value = "List IL JUG Members", notes = "Returns the IL JUG Members list")
	public Iterable<IlJugMember> getAllIJugMembers() {
		return ilJugMemberService.getAllIlJugMembers();
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = { "application/json" })
	@ApiOperation(value = "Find IL JUG Member by last name", notes = "Returns the IL JUG Members with matching last name")
	public Iterable<IlJugMember> searchIJugMembersByLastName(
			@ApiParam(value = "Last name of IL JUG Member", required = true) @RequestParam("last") String lastName) {
		return ilJugMemberService.findIlJugMemberByLastName(lastName);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete IL JUG Member", notes = "Deletes the IL JUG Member from the system")
	public void delete(
			@ApiParam(value = "ID of the IL JUG Member", required = true) @PathVariable("id") Long id) {
		ilJugMemberService.deleteIlJugMember(id);
	}

}

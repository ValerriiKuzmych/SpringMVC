package com.kuzmych.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class CalculatorController {

	@GetMapping("/calculator")
	public String helloPage(HttpServletRequest request, Model model) {
		String value1 = request.getParameter("value1");
		String value2 = request.getParameter("value2");
		String action = request.getParameter("action");

		try {
			int intValue1 = Integer.parseInt(value1);
			int intValue2 = Integer.parseInt(value2);

			double result;
			if (action.equals("/")) {
				result = intValue1 / intValue2;
			} else if (action.equals("*")) {
				result = intValue1 * intValue2;
			} else if (action.equals("+")) {
				result = intValue1 + intValue2;
			} else if (action.equals("-")) {
				result = intValue1 - intValue2;
			} else {
				model.addAttribute("calculate", "Enter a valid action: /, *, +, -.");
				return "first/calculator";
			}

			model.addAttribute("calculate", result);
		} catch (NumberFormatException e) {
			model.addAttribute("calculate", "Enter valid integer values.");
		}

		return "first/calculator";
	}

}

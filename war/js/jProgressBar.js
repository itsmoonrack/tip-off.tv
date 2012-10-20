// jProgressBar a simple jQuery progress bar plugin by Donavon West
// Copyright 2009 Donavon West. All rights reserved

(function($, document) {
//--------------------

$.fn.jProgressBar = function() {

	var that = this;

	// ------------------------
	// local helper functions
	
	function createElement(p_tag, p_class) {
		var el = document.createElement(p_tag);
		if (p_class) {
			el.className = p_class;
		}
		return el;
	}
	
	function setPercent(p_el, p_percent, p_orientation) {
		if (p_orientation) {
			p_el.style.height = p_percent + "%";
		} else {
			p_el.style.width = p_percent + "%";
		}
	}

	//returns the third child element	
	function getBarEl(p_this) {
		return $.data(p_this, "jProgressBar.progressBarEl");
		//return $(p_this).children().eq(0).children().eq(0).children()[0]; 
	}

	// ------------------------
	// class methods
	
	that.dispose = function() {
		return that.empty();
	};

	// create the markup to form a progress bar
	that.initialize = function(p_percent, p_settings) {
		var settings = jQuery.extend({
			width: 100,
			height: 12,
			orientation: 0,
			border: {
				width: 1
			}
		}, p_settings);

		return this.each(function() {
		
			var style;
			p_percent = p_percent ? p_percent : 0;
			
			$.data(this, "jProgressBar.settings", settings);
		
			//create the outer "quirks mode" compatible border div
			var borderEl = createElement("div", "border");
			style = borderEl.style; //minify trick
			style.position = "relative";
			var tmp = settings.border.width*2;
			style.height = (settings.height + tmp)+"px";
			style.width = (settings.width + tmp)+"px";
			this.appendChild(borderEl);

			//create the background div
			var backgroundEl = createElement("div", "background");
			style = backgroundEl.style;
			style.position = "absolute";
			style.height = settings.height + "px";
			style.width = settings.width + "px";
			style.top = backgroundEl.style.left = (settings.border.width + "px");
			style.overflow = "hidden";
			borderEl.appendChild(backgroundEl);
			
			//create the percent bar div
			var progressBarEl = createElement("div", "bar");
			style = progressBarEl.style;
			style.position = "relative";
			style.top = progressBarEl.style.left = "0px";
			backgroundEl.appendChild(progressBarEl);
			if (settings.orientation) {
				setPercent(progressBarEl, p_percent, settings.orientation);
				style.width = settings.width + "px";
			} else {
				setPercent(progressBarEl, p_percent, settings.orientation);
				style.height = settings.height + "px";
			}
			$.data(this, "jProgressBar.progressBarEl", progressBarEl); //save a pointer to the bar element for quick retreival
			
			
		});
	};

	// set the bar percentage	
	that.setPercent = function(p_percent) {
		var settings;
		return this.each(function() {
			settings = $.data(this, "jProgressBar.settings");
			setPercent(getBarEl(this), p_percent, settings.orientation);
		});
	};

	//set the bar color (in cases where a class isn't defined for the bar)
	that.setBarColor = function(p_color) {
		return this.each(function() {
			getBarEl(this).style.backgroundColor = p_color;
		});
	};


	//constructor code
	if (arguments.length) { 
		//passed arguments ex:jProgressBar({width:125}) 
		if ($.data(this[0], "jProgressBar.settings")) { //throw an error if the zeroth element is already initialized
			throw "jProgressBar already initialized";
		} else {
			this.initialize.apply(this, arguments); //no, initialize all elements
		}
	} else {
		//no passed arguments (i.e. a re-cast)
		if (!$.data(this[0], "jProgressBar.settings")) { //throw an error if the zeroth element is not initialized
			throw "jProgressBar not initialized (can not cast)";
		}
	}
	
	return this;

};

//--------------------
})(jQuery, document); //minify trick, plus don't EVER assume that $ is the jQuery object. it's just bad